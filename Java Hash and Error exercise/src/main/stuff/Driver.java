package main.stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Driver {

	public static void main(String[] args) {
		String hashClass = args[0];
		String hashBuildFile = args[1];

		String hashSearchFile = args[2];

		try {
			
			Class<?> clazz = Class.forName(hashClass);

			
			if (!MyHash.class.isAssignableFrom(clazz)) {
				System.err.println(hashClass + " is not a subclass of MyHash");
				return;
			}

			
			Constructor<?> constructor = clazz.getConstructor(String.class);

			
			long start = System.currentTimeMillis();

			
			MyHash myHashInstance = (MyHash) constructor.newInstance(hashBuildFile);

			
			long buildHash = System.currentTimeMillis() - start;

			System.out.println("The algorithm " + hashClass + " took " + buildHash + "ms to build its hash table.");

			
			BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir"), hashSearchFile).getAbsolutePath()));
			String line;
			int notFoundCount = 0;
			while ((line = reader.readLine()) != null) {
				String str = line.trim();
				if (!str.isEmpty()) {
					try {
						myHashInstance.find(str);
					} catch (NotFoundException e) {
						
						System.out.println("Could not find: " + str);
						++notFoundCount;
					} catch (TooFullException e) {
						
						System.out.println("Gave up trying to find: " + str);
						++notFoundCount;
					}
				}
			}
			reader.close();

			
			System.out.println("Could not find count: " + notFoundCount);

		} catch (ClassNotFoundException e) {
			
			System.err.println("Class " + hashClass + " not found");
		} catch (NoSuchMethodException e) {
			
			System.err.println("No suitable constructor found in class " + hashClass);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			
			System.err.println("Error creating instance of class " + hashClass);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}


	}

}
