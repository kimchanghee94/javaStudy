package class2;

public class ClassLoaderTest {
	public static void main(String[] args) {
		
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
	}
}
