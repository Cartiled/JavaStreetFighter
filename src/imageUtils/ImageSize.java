package imageUtils;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageSize {

	public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {

		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_AREA_AVERAGING);
		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

		return outputImage;

	}

}
