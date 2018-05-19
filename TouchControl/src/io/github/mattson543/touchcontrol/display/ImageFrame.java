package io.github.mattson543.touchcontrol.display;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * Frame - GUI container for components (holds ImagePanel)
 *
 * @author mattson543
 */
@SuppressWarnings("serial")
public class ImageFrame extends JFrame
{
	/**
	 * Whether or not the frame is currently open
	 */
	private boolean isOpen;
	/**
	 * Panel to hold/display a BufferedImage
	 */
	private ImagePanel imagePanel;

	public ImageFrame()
	{
		super();
		buildGUI();
	}

	/**
	 * Externally called to see if display frame is still open.
	 *
	 * @return Open status
	 */
	public boolean isOpen()
	{
		return isOpen;
	}

	/**
	 * Construct the display and its children
	 */
	private void buildGUI()
	{
		//Create frame
		setTitle("Touch Control");
		addWindowListener(createWindowListener());
		imagePanel = new ImagePanel();
		add(imagePanel);
		setVisible(true);
		isOpen = true;
	}

	/**
	 * Create a listener to monitor the frame closing event.
	 *
	 * @return WindowListener
	 */
	private WindowListener createWindowListener()
	{
		WindowListener listener = new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent windowClosed)
			{
				//Set window closing events
				isOpen = false;
			}
		};

		return listener;
	}

	/**
	 * Display an image in the frame.
	 *
	 * @param image
	 *            Image to be shown
	 */
	public void showImage(BufferedImage image)
	{
		//Send image to panel
		imagePanel.setImage(image);

		//Redraw frame
		this.repaint();

		//Resize frame to fit image
		pack();
	}
}