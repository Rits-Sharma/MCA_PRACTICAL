# to run first install opencv via terminal : pip install opencv-python

import cv2 

# to check version of installed opencv
# ===============================================
# print(cv2.__version__)

# 1. Load an image
# ===============================================
img = cv2.imread("bird.jpg")              # reads image as Numpy array in BGR format
# print(img)

# # 2. Inspect the image
# # ===============================================
# print("Shape: ", img.shape)             # Shape: (height, width, color_channels)
# print("Data type: ", img.dtype)         # unit8 -> 8-bit image(0-255)

# print("Height: ", img.shape[0])
# print("Width: ", img.shape[1])

# 3. Show the image (OpenCV window)
# ===============================================
cv2.imshow("Bike image", img)
cv2.waitKey(0)                             # 0 = wait forever, wihtout it the window closes immediately
cv2.destroyAllWindows()

# # 4. Save an image
# # ===============================================
# cv2.imwrite("myImage.png", img)

# # 5. Pixel access (THIS MAKES IT CLICK)
# # ===============================================
# pixel = img[10,10]                      # row, column
# print(pixel)                            # [B, G, R]

# for i in range(10,100):
#     img[1,100] = [0,0,255]              # red pixel

# cv2.imshow("Pixel changed", img)
# cv2.waitKey(0)                          
# cv2.destroyAllWindows()

# 6. Resize image
# ===============================================
img_resized = cv2.resize(img, (500,500))   # width, height
cv2.imshow("Resized Image", img_resized)
cv2.waitKey(0)                          
cv2.destroyAllWindows()

# 7. BGR vs RGB
# ===============================================
img_rgb = cv2.cvtColor(img_resized, cv2.COLOR_BGR2RGB)
cv2.imshow("COLOR_BGR2RGB", img_rgb)
cv2.waitKey(0)                          
cv2.destroyAllWindows()


# # 8. Crop an image
# # ===============================================
# img_cropped = img[50:200, 200:400]        # row_start:row_end, col_start:col_end
# cv2.imshow("Cropped image", img_cropped)
# cv2.waitKey(0)                          
# cv2.destroyAllWindows()

# # 9. Grayscale image
# # ===============================================
# img_gray = cv2.cvtColor(img_rgb, cv2.COLOR_BGR2GRAY)
# cv2.imshow("Grayscale image", img_gray)
# cv2.waitKey(0)                          
# cv2.destroyAllWindows()

# Create a red block
for i in range(50,200):
    for j in range(50,200):
        img_resized[i,j] = [0,0,255]        # red pixel

cv2.imshow("Red block image", img_resized)
cv2.waitKey(0)                          
cv2.destroyAllWindows()

