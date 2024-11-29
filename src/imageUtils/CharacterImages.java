package imageUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class CharacterImages {

	public String[] names = { "onFeet1", "onFeet2", "onFeet3", "onFeet4", "onFeet5", "onFeet6", "onFeet7", "onFeet8",
			"onFeet9" };
	

	public HashMap<String, BufferedImage> loadCharacterImage() {
		HashMap<String, BufferedImage> ret = new HashMap<String, BufferedImage>();
	
		try {
		
		for (int i = 0; i < names.length; i++) {
			BufferedImage bf = ImageIO.read(new FileInputStream(new File("resources/Yagami/"+names[i]+".png")));
			ret.put(names[i], bf);
		}
		
		}catch( IOException e){
			e.printStackTrace();
		}
		return ret;
	}

}
