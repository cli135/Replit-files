import numpy as np
from matplotlib import pyplot as plt

# load and show an image with Pillow
from PIL import Image

# Open the image form working directory
# filename = 'img].jpeg'
def main():
    filename = 'ocaml logo.png'

    image = Image.open(filename)
    numpydata = np.asarray(image)
    print(type(numpydata))
    print(numpydata.shape)
    # summarize some details about the image

    print(image.format)

    print(image.size)

    print(image.mode)

    # PIL pillow to get an image maybe
    # random_image = np.random.random([500, 500])
    # let's try 160 width in terminal
    # width = 80
    terminal_width = 160
    aspect_ratio = 16 / 9
    terminal_height = int(terminal_width / aspect_ratio)
    # img = np.zeros((terminal_height, terminal_width))
    img = numpydata
    # plt.imshow(random_image, cmap='gray')
    # plt.colorbar();

    pixel_ascii_map = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"

    max_in_array = np.amax(img)
    max_val = max_in_array
    max_val = 1 if max_val == 0 else max_val
    print(max_val)
    for j in range(terminal_height):
      for i in range(terminal_width):
        actual_height = img.shape[0]
        actual_width = img.shape[1]
        sampled_j = (j / terminal_height) * actual_height
        sampled_i = (i / terminal_width) * actual_width
        # nearest_j = int(round(sampled_j))
        # nearest_i = int(round(sampled_i))
        nearest_j = int(sampled_j)
        nearest_i = int(sampled_i)
        val = img[nearest_j, nearest_i]
        # print(val)
        # print(type(val))
        # print(val.size)
        # print(val.shape)
        avg_val: float = np.average(val)
        ascii_val_idx = int(avg_val / max_val * (len(pixel_ascii_map) - 1))
        ascii_val = pixel_ascii_map[ascii_val_idx]
        print(ascii_val * 2, end="")
      print('\n', end="")


if __name__ == "__main__":
    main()