package com.lumia.windows;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * 获取windows磁盘卷标
 * @author heihaier
 *
 */
public class DriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] roors = File.listRoots();
		
		if ( roors != null && roors.length > 0 ) {
			
			for ( File f : roors ) {
				System.out.println( fsv.getSystemDisplayName( f ) );
			}
		}
	}

}
