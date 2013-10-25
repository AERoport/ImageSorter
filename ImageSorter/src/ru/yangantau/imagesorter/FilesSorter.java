package ru.yangantau.imagesorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;

class DirectoryIterator {
	private File currentPath;

	public DirectoryIterator(File currentPath) {
		this.currentPath = currentPath;
	}

	public void showTag(Directory dir1, int tagType) {
		if (dir1.containsTag(tagType)) {
			System.out.print("Name:" + dir1.getTagName(tagType));
			System.out.println("\tDescription:" + dir1.getDescription(tagType));

		}
	}

	public void iterFiles() throws ImageProcessingException, IOException {
		// File parent = currentPath.getParentFile();
		File parent = currentPath;

		//System.out.println("parent.getAbsolutePath() is:"
		//		+ parent.getAbsolutePath());
		//System.out.println();

		File[] files = parent.listFiles();
		for (File theFile : files) {
			// System.out.print("theFile.getAbsolutePath() is:"
			// + theFile.getAbsolutePath());
			if (theFile.isFile()) {
				System.out.println(theFile.getAbsolutePath());

				// System.out.print(" - Это файл");
				try {
					Metadata metadata = ImageMetadataReader
							.readMetadata(theFile);

					Directory exifSubIFDDirectory = metadata
							.getDirectory(ExifSubIFDDirectory.class);
					if (exifSubIFDDirectory != null) {
						int tag = ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL;
						showTag(exifSubIFDDirectory, tag);

						Date asDate = exifSubIFDDirectory.getDate(tag);
						// System.out.println(asDate);
						String dirName = String.format("%1$tY_%1$tm_%1$td",
								asDate);
						System.out.println(dirName);

						// make directory if not exist
						File child = new File(parent, dirName);
						System.out.print(child.getAbsolutePath());

						File newTheFile = new File(child, theFile.getName());

						if (child.exists()) {
							Files.move(theFile.toPath(), newTheFile.toPath());
						} else if (child.mkdir()) {
							System.out.println(" -Создано");
							Files.move(theFile.toPath(), newTheFile.toPath());
						} else {
							System.out.println(" -Не создано");

						}

						showTag(exifSubIFDDirectory,
								ExifSubIFDDirectory.TAG_DATETIME_DIGITIZED);
					}
					/*
					 * for (Directory dir1 : metadata.getDirectories()) { if
					 * (dir1.getName() == "Exif SubIFD") { } int
					 * ORIG_DATE_TIME_TYPE = 36867; // Original // Date/Time if
					 * (dir1.containsTag(ORIG_DATE_TIME_TYPE)) { //
					 * 
					 * showTag(dir1, ORIG_DATE_TIME_TYPE);
					 * 
					 * final int DIG_DATE_TIME_TYPE = 36868; if
					 * (dir1.containsTag(DIG_DATE_TIME_TYPE)){ showTag(dir1,
					 * DIG_DATE_TIME_TYPE); } }
					 */

				} catch (ImageProcessingException e) {
					System.err.println("Ошибка ImageProcessing: " + theFile
							+ "\n" + e);
				} catch (IOException e) {
					System.err.println("Ошибка IOException: " + theFile + "\n"
							+ e);
				}
			}
		}
	}// iterFiles

	public void showMetadata() throws ImageProcessingException, IOException {
		Metadata metadata = ImageMetadataReader.readMetadata(currentPath);

		for (Directory directory : metadata.getDirectories()) {
			System.out.println("DirectoryName:[" + directory.getName() + "] ");
			for (Tag tag : directory.getTags()) {
				// System.out.println(tag);
				System.out.print("Name:" + tag.getTagName());
				System.out.print("\tType:" + tag.getTagType());
				System.out.println("\tDescription:" + tag.getDescription());
			}
			System.out.println();

			/*
			 * Iterable<Directory> directories = metadata.getDirectories();
			 * Iterator<Directory> dirIt = directories.iterator();
			 * while(dirIt.hasNext()) { Directory directory =dirIt.next();
			 * directory.getName(); }
			 */
		} // showMetadata

	}
} // class DirectoryIterator

public class FilesSorter {

	public static void main(String[] args) throws
			IOException, ImageProcessingException 
			{
		File ff = new File(".");
		String path = ff.getAbsolutePath();
		// System.out.println("ff.getAbsolutePath():"+ path);
		path = path.substring(0, path.length() - 1);
		System.out.println("path:" + path);
		File jpegPath = new File(path);
		// File jpegPath = new File("d:\\!Java\\!!_Jpg\\");
		// jpegPath.
		DirectoryIterator dIterator1 = new DirectoryIterator(jpegPath);
		// dIterator1.showMetadata();

		dIterator1.iterFiles();
	}

}
