package class2;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

	// 인스턴스가 생성될 때 현재 클래스로더의 부모 클래스로더도 설정해 줘야 한다
	public ClassLoaderTest(ClassLoader parent) {
	        super(parent);
	    }

	// 클래스가 포함된 패키지로부터 클래스를 로드하여 Class 인스턴스를 생성하고 리턴한다
	private Class getClass(String name) throws ClassNotFoundException {
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] buf = null;
		try {
			// 파일 시스템으로부터 .class 파일을 byte[]으로 로드한다
			buf = loadBytes(file);
			// byte[]를 지정된 이름의 클래스에 해당하는 Class 인스턴스로 변환한다
			Class cls = defineClass(name, buf, 0, buf.length);
			resolveClass(cls); // 링크한다. 이미 링크된 경우에는 아무 것도 하지 않는다
			return cls;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// JVM은 클래스를 로드할 때 이 메소드를 호출하여 클래스를 로드한다.
	// 현재 프로그램(특정 패키지)에 포함된 클래스만 커스텀 클래스로더를 이용하여 로드하고
	// 시스템 클래스는 시스템 클래스로더가 로드하도록 위임한다(Delegation)
	@Override
	public Class loadClass(String name) throws ClassNotFoundException {
		System.out.println("로드 시작(" + name + ")");
		if (name.startsWith("class2")) {
			System.out.println("\t\t\t--> by MyClassLoader");
			return getClass(name);
		}
		return super.loadClass(name);
	}

	// 파일 시스템에서 .class 파일을 읽어서 byte[] 형으로 리턴한다
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
		 * java.base.jdk.internal.loader.ClassLoaders클래스 static 초기화 블록을 보면
		 * 
		 * Boot로더를 생성하고 Platform로더를 생성(Ext로 간주된다) 마지막에 AppLoader를 생성하고있다.
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
