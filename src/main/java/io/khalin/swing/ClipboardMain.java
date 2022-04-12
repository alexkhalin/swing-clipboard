package io.khalin.swing;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClipboardMain {

	private static void clipboardPaste() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		if (!clipboard.isDataFlavorAvailable(DataFlavor.javaFileListFlavor))
			return;

		try {
			System.out.println(new ArrayList<>().getClass().getName());
			@SuppressWarnings("unchecked")
			List<File> files = (List<File>) clipboard.getContents(null).getTransferData(DataFlavor.javaFileListFlavor);
			for (File file : files) {
				System.out.println(file.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		clipboardPaste();
	}
}
