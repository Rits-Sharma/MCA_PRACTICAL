import cv2
import numpy as np

img = np.zeros((512,512,3), np.uint8)
print(img)

# img[:] = 255,0,0               #BGR -> Bue color is applied to all pixels
# img[100:200, 200:500] = 255,0,0  # It is applied to the pixels in the range of the given coordinates      

# cv2.line(img, (0,0), (300,300), (0,0,255), 4)       # Draw a line from starting point(0,0) to end point(300,300) with thte width of 4
# cv2.line(img, (0,0), (img.shape[1],img.shape[0]), (0,0,255), 4) # img.shape[1] is the width 
# cv2.rectangle(img, (0,0), (250,350), (25,55,2), 3)
# cv2.rectangle(img, (0,0), (250,350), (25,55,2), cv2.FILLED)
# cv2.circle(img, (252,252), 30, (0,252,255), 4)
cv2.putText(img, "Ritesh Sharma", (100,100), cv2.FONT_HERSHEY_SIMPLEX, 1.5, (245,41,83), 2)

cv2.imshow("image", img)
cv2.waitKey(0)
cv2.destroyAllWindows()