import cv2

img = cv2.imread("Resources/bird.jpg")
print(img.shape)        # Height, Width, Channels (768, 1024, 3)

imgResize = cv2.resize(img, (512, 384))     # Resize to (Width, Height)
imgCropped = imgResize[0:200, 200:500]

cv2.imshow("Resized Image", imgResize)
cv2.imshow("Cropped Image", imgCropped)

cv2.waitKey(0)
cv2.destroyAllWindows()