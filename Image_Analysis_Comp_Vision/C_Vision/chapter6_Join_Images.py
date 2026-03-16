import cv2
import numpy as np
import StackImages as si

img = cv2.imread("Resources/Pagani.png")
imgStacked = si.stackImages(0.9, ([img, img, img]))

# imgHorizontal = np.hstack((img, img))
# imgVerical = np.vstack((img, img))

# cv2.imshow("Image", img)
# cv2.imshow("Horizontal Image", imgHorizontal)
# cv2.imshow("Horizontal Image", imgVerical)
cv2.imshow("Stacked Image", imgStacked)
cv2.waitKey(0)
cv2.destroyAllWindows()
