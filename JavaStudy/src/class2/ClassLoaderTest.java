package class2;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

	// �ν��Ͻ��� ������ �� ���� Ŭ�����δ��� �θ� Ŭ�����δ��� ������ ��� �Ѵ�
	public ClassLoaderTest(ClassLoader parent) {
	        super(parent);
	    }

	// Ŭ������ ���Ե� ��Ű���κ��� Ŭ������ �ε��Ͽ� Class �ν��Ͻ��� �����ϰ� �����Ѵ�
	private Class getClass(String name) throws ClassNotFoundException {
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] buf = null;
		try {
			// ���� �ý������κ��� .class ������ byte[]���� �ε��Ѵ�
			buf = loadBytes(file);
			// byte[]�� ������ �̸��� Ŭ������ �ش��ϴ� Class �ν��Ͻ��� ��ȯ�Ѵ�
			Class cls = defineClass(name, buf, 0, buf.length);
			resolveClass(cls); // ��ũ�Ѵ�. �̹� ��ũ�� ��쿡�� �ƹ� �͵� ���� �ʴ´�
			return cls;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// JVM�� Ŭ������ �ε��� �� �� �޼ҵ带 ȣ���Ͽ� Ŭ������ �ε��Ѵ�.
	// ���� ���α׷�(Ư�� ��Ű��)�� ���Ե� Ŭ������ Ŀ���� Ŭ�����δ��� �̿��Ͽ� �ε��ϰ�
	// �ý��� Ŭ������ �ý��� Ŭ�����δ��� �ε��ϵ��� �����Ѵ�(Delegation)
	@Override
	public Class loadClass(String name) throws ClassNotFoundException {
		System.out.println("�ε� ����(" + name + ")");
		if (name.startsWith("class2")) {
			System.out.println("\t\t\t--> by MyClassLoader");
			return getClass(name);
		}
		return super.loadClass(name);
	}

	// ���� �ý��ۿ��� .class ������ �о byte[] ������ �����Ѵ�
	private byte[] loadBytes(String name) throws IOException {
		InputStream stream = getClass().getClassLoader().getResourceAsStream(name);
		int size = stream.available();
		byte buff[] = new byte[size];
		DataInputStream in = new DataInputStream(stream);
		in.readFully(buff);
		in.close();
		return buff;
	}
	
		/*
		 * java.base.jdk.internal.loader.ClassLoadersŬ���� static �ʱ�ȭ ����� ����
		 * 
		 * Boot�δ��� �����ϰ� Platform�δ��� ����(Ext�� ���ֵȴ�) �������� AppLoader�� �����ϰ��ִ�.
		 * 
		// Creates the built-in class loaders.
		    static {
		        // -Xbootclasspath/a or -javaagent with Boot-Class-Path attribute
		        String append = VM.getSavedProperty("jdk.boot.class.path.append");
		        BOOT_LOADER =
		            new BootClassLoader((append != null && append.length() > 0)
		                ? new URLClassPath(append, true)
		                : null);
		        PLATFORM_LOADER = new PlatformClassLoader(BOOT_LOADER);

		        // A class path is required when no initial module is specified.
		        // In this case the class path defaults to "", meaning the current
		        // working directory.  When an initial module is specified, on the
		        // contrary, we drop this historic interpretation of the empty
		        // string and instead treat it as unspecified.
		        String cp = System.getProperty("java.class.path");
		        if (cp == null || cp.length() == 0) {
		            String initialModuleName = System.getProperty("jdk.module.main");
		            cp = (initialModuleName == null) ? "" : null;
		        }
		        URLClassPath ucp = new URLClassPath(cp, false);
		        APP_LOADER = new AppClassLoader(PLATFORM_LOADER, ucp);
		    }
	    */
	/*ClassLoaderTest() {
		super();
		System.out.println("Child ClassLoader constructor");
	}

	@Override
	public Class findClass(String name) throws ClassNotFoundException {
		System.out.println("================================Custom Class Loader=====================================");
		System.out.println(ClassLoaderTest.class.getClassLoader());
		byte[] b = loadClassFromFile(name);
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassFromFile(String fileName) {
		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(fileName.replace('.', File.separatorChar) + ".class");
		byte[] buffer;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		int nextValue = 0;
		try {
			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer = byteStream.toByteArray();
		return buffer;
	}*/
}
