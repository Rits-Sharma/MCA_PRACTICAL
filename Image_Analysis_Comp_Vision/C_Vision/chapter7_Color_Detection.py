import cv2
import StackImages

cv2.namedWindow("Trackbars")
cv2.resizeWindow("Trackbars", 640, 240)
cv2.createTrackbar("Hue Min", "Trackbars", 18, 179, lambda x: None)
cv2.createTrackbar("Hue Max", "Trackbars", 165, 179, lambda x: None)
cv2.createTrackbar("Sat Min", "Trackbars", 0, 255, lambda x: None)
cv2.createTrackbar("Sat Max", "Trackbars", 176, 255, lambda x: None)
cv2.createTrackbar("Val Min", "Trackbars", 61, 255, lambda x: None)
cv2.createTrackbar("Val Max", "Trackbars", 218, 255, lambda x: None)

img = cv2.imread("Resources/block.jpg")
imgHSV = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

while True:
    h_min = cv2.getTrackbarPos("Hue Min", "Trackbars")
    h_max = cv2.getTrackbarPos("Hue Max", "Trackbars")
    s_min = cv2.getTrackbarPos("Sat Min", "Trackbars")
    s_max = cv2.getTrackbarPos("Sat Max", "Trackbars")
    v_min = cv2.getTrackbarPos("Val Min", "Trackbars")
    v_max = cv2.getTrackbarPos("Val Max", "Trackbars")
    print(h_min, h_max, s_min, s_max, v_min, v_max)
    mask = cv2.inRange(imgHSV, (h_min, s_min, v_min), (h_max, s_max, v_max))
    imgResult = cv2.bitwise_and(img, img, mask=mask)

    imgStack = StackImages.stackImages(0.6, ([img, imgHSV], [mask, imgResult]))

    # cv2.imshow("Photo", img)
    # cv2.imshow("HSV", imgHSV)
    # cv2.imshow("Mask", mask)
    # cv2.imshow("Result", imgResult)
    cv2.imshow("Stack", imgStack)
    cv2.waitKey(1)