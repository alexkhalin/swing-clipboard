package io.khalin.swing;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.List;

public class ClipboardMain {

	private static void clipboardPaste() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

		if (!clipboard.isDataFlavorAvailable(DataFlavor.javaFileListFlavor))
			return;
		Object o = null;
		try {
			o = clipboard.getContents(null).getTransferData(DataFlavor.javaFileListFlavor);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (o != null && o instanceof List) {
			@SuppressWarnings("unchecked")
			List<File> files = (List<File>) o;
			for (File file : files) {
				System.out.println(file.getName());
			}
		}

	}

	public static void main(String[] args) {
		clipboardPaste();
	}
}
