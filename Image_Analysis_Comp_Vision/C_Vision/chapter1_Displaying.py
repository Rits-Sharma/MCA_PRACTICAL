import cv2
print("OpenCV version:", cv2.__version__)

# Image loading and displaying
"""
img = cv2.imread("Resources/bird.jpg")
cv2.imshow("Image", img)
cv2.waitKey(0)          # 0 means infinit delay, and any other value are representing the delay in milliseconds
cv2.destroyAllWindows()
"""

# Video loading and displaying
"""
cap = cv2.VideoCapture("bird.mp4")
# Video is a sequence of images, so we need to read it frame by frame
while True:
    success, img = cap.read()
    cv2.imshow("Video", img)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()
"""

# Webcam video capture and displaying
"""
cap = cv2.VideoCapture(0)   # 0 for default webcam, 1 for external webcam
cap.set(3, 640)         # set width
cap.set(4, 480)         # set height
while True:
    success, img = cap.read()
    cv2.imshow("Video", img)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
cap.release()
cv2.destroyAllWindows()
"""
