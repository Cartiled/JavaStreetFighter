package threads;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public boolean lightAttack, kickAttack, downpunch, downKick;

	@Override
	public void keyTyped(KeyEvent e) {
		int code = e.getKeyChar();

		if (code == KeyEvent.VK_J) {
			lightAttack = true;

		}
		if (code == KeyEvent.VK_K) {
			kickAttack = true;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = true;

		}
		if (code == KeyEvent.VK_S) {
			downPressed = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (code == KeyEvent.VK_S) {

			downPressed = false;
		}
		if (code == KeyEvent.VK_J) {
			lightAttack = false;

		}
		if (code == KeyEvent.VK_K) {
			kickAttack = false;

		}

	}

}
