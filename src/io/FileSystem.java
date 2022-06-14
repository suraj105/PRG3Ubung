package io;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    public static  void writeJBP(String fileName, List items) {

        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(Files.newOutputStream(Paths.get("/home/apex/Downloads/prg3Ubung3/prg3/src/test/"+fileName))))) {

            encoder.writeObject(items);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static  List readJBP(String fileName) {

        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("/home/apex/Downloads/prg3Ubung3/prg3/src/test/"+fileName)))) {

            return (List) decoder.readObject();

        } catch (Exception e) {
            System.out.println(e);        }

        return new ArrayList<>();

    }

    public static void writeJOS(String filename, List items) {

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("/home/apex/Downloads/prg3Ubung3/prg3/src/test/"+filename)))) {

            oos.writeObject(items);

        } catch (Exception e) {
            System.out.println(e);        }

    }

    public static  List readJOS(String filename) {

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("/home/apex/Downloads/prg3Ubung3/prg3/src/test/"+filename)))) {

            return (List) ois.readObject();

        } catch (Exception e) {
            System.out.println(e);        }

        return new ArrayList<>();

    }
}