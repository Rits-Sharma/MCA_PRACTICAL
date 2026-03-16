import cv2
import numpy as np
from flask import Flask, Response, render_template_string

app = Flask(__name__)

# --- 1. Camera Setup & Variables ---
cap = cv2.VideoCapture(0)
cap.set(3, 640)
cap.set(4, 480)
cap.set(10, 150)

myColors = [[170, 100, 100, 180, 255, 255],   # Red
            [100, 100, 100, 130, 255, 255]]    # Blue
myColorValue = [[0, 0, 255], [255, 0, 0]]
myPoints = []

# --- 2. Helper Functions ---
def getContours(img):
    contours, hierarchy = cv2.findContours(img, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_NONE)
    x, y, w, h = 0, 0, 0, 0
    for cnt in contours:
        area = cv2.contourArea(cnt)
        if area > 500:
            peri = cv2.arcLength(cnt, True)
            approx = cv2.approxPolyDP(cnt, 0.02 * peri, True)
            x, y, w, h = cv2.boundingRect(approx)
    return x + w // 2, y

def findColor(img, myColors, myColorValue, imgResult):
    imgHSV = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
    count = 0
    newPoints = []
    for color in myColors:
        lower = np.array(color[0:3])
        upper = np.array(color[3:6])
        mask = cv2.inRange(imgHSV, lower, upper)
        x, y = getContours(mask)
        cv2.circle(imgResult, (x, y), 10, myColorValue[count], cv2.FILLED)
        if x != 0 and y != 0:
            newPoints.append([x, y, count])
        count += 1
    return newPoints

def drawOnCanvas(myPoints, myColorValue, imgResult):
    for point in myPoints:
        cv2.circle(imgResult, (point[0], point[1]), 10, myColorValue[point[2]], cv2.FILLED)

# --- 3. Flask Generator & Routes ---
def generate_frames():
    global myPoints  # This allows the generator to remember the drawn points across frames
    
    while True:
        success, img = cap.read()
        if not success:
            break
        else:
            imgResult = img.copy()
            
            # Run your OpenCV processing on the current frame
            newPoints = findColor(img, myColors, myColorValue, imgResult)
            if len(newPoints) != 0:
                for newP in newPoints:
                    myPoints.append(newP)
            if len(myPoints) != 0:
                drawOnCanvas(myPoints, myColorValue, imgResult)
            
            # Encode and yield the final drawn frame
            ret, buffer = cv2.imencode('.jpg', imgResult)
            frame_bytes = buffer.tobytes()
            
            yield (b'--frame\r\n'
                   b'Content-Type: image/jpeg\r\n\r\n' + frame_bytes + b'\r\n')

@app.route('/')
def index():
    html = '''
    <!DOCTYPE html>
    <html>
    <head><title>Virtual Painter 🎨</title></head>
    <body>
        <h1>Virtual Painter Stream</h1>
        <img src="/video_feed" width="640" height="480">
    </body>
    </html>
    '''
    return render_template_string(html)

@app.route('/video_feed')
def video_feed():
    return Response(generate_frames(), mimetype='multipart/x-mixed-replace; boundary=frame')

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)