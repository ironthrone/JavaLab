package classloader;

import java.io.*;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MyClassLoader extends ClassLoader {

    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        byte[] classData = getClassData(name);
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] getClassData(String name) {
        String fullPath = getClassFullPath(name);
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(fullPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {

                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    private String getClassFullPath(String name) {
        return rootDir + File.separator + name.replace(".", File.separator)
                + ".class";
    }
}
