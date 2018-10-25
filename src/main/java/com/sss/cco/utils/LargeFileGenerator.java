package com.sss.cco.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class LargeFileGenerator {

	private static final Double ONE_GB = Math.pow(1024, 3);
	private static final Double ONE_MB = Math.pow(1024, 2);
	private static final Double ONE_KB = Math.pow(1024, 1);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		String help = "Usage: java -jar lfg.jar <GB|MB|KB> [file name] [file size]";
		if(args.length >= 1 && args.length <= 3) {
			Double unit = 0.0d;
			switch(args[0]) {
			case "GB": unit = ONE_GB;
				break;
			case "MB": unit = ONE_MB;
				break;
			case "KB": unit = ONE_KB;
				break;
			}
			if(unit != 0.0d) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				/*System.out.print("Enter file size in " + args[0] + ": ");
				Integer amount = Integer.parseInt(br.readLine());*/
				Integer amount = args.length == 3 ? Integer.parseInt(args[2]) : 1;
				//System.out.print("Enter file name (Press Enter to use generated name): ");
				String fileName = args.length == 1 ? br.readLine() : args[1];
				if(fileName == null || fileName.length() == 0) {
					fileName = "fut-" + amount+ "-" + args[0];
				}
				Double size = unit * amount;
				File file = new File(fileName);
				RandomAccessFile largeFile = new RandomAccessFile(file, "rw");
				largeFile.setLength(size.longValue());
				largeFile.close();
				System.out.println("File created at: " + file.getAbsolutePath());
			} else {
				System.out.println("Unrecognized argument: " + args[0] + ". " + help);
			}
		} else {
			System.out.println("Invalid number of arguments: " + Arrays.toString(args) + ". " + help);
		}
	}

}
