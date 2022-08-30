package arquivos;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        // acessando arquivos com File

        File planilha1 = new File("/home/usuario/planilha/custos.txt");
        File planilha2 = new File("/home/usuario", "planilha/custos.txt");
        File parent = new File("/home/usuario");
        File planilha3 = new File(parent, "planilha/custos.txt");


        // acessando arquivos com Path

        Path planilha1Path = Path.of("/home/usuario/planilha/custos.txt");
        Path planilha2Path = Path.of("/home", "usuario", "planilha", "custos.txt");

        Path planilha3Path = Paths.get("/home/usuario/planilha/custos.txt");
        Path planilha4Path = Paths.get("/home", "usuario", "planilha", "custos.txt");

        Path path = planilha1.toPath();
        File file = path.toFile();


        infoIO(planilha1);
        infoNIO(planilha1Path);


        File file1 = new File("/Users/eduardosantana/teste.txt");
        Path path1 = Path.of("/Users/eduardosantana/teste.txt");


        infoIO(file1);
        infoNIO(path1);


        File dir1 = new File("/Users/eduardosantana/");
        Path dir2 = Path.of("/Users/eduardosantana/");


        infoIO(dir1);
        infoNIO(dir2);


        path = Paths.get("/Users/eduardosantana/teste.txt");
        System.out.println("Path: " + path);
        for(int i=0; i<path.getNameCount(); i++) {
            System.out.println(" Elemento " + i + " eh: " + path.getName(i));
        }

        System.out.println();
        System.out.println("subpath(0,3): " + path.subpath(0, 3));
        System.out.println("subpath(1,2): " + path.subpath(1, 2));
        System.out.println("subpath(1,3): " + path.subpath(1, 3));


        imprimirInformacoesDoPath(path);


        path1 = Path.of("/data/../temp");
        Path path2 = Path.of("user");
        System.out.println(path1.resolve(path2)); //  imprime "/data/../temp/user"


        var p1 = Path.of("./user/../planilha.txt");
        System.out.println(p1.normalize()); // planilha.txt

        var p2 = Path.of("/temp/../lista/comidas");
        System.out.println(p2.normalize()); // /lista/comidas

        var p3 = Path.of("../../planilha.txt");
        System.out.println(p3.normalize()); // ../../planilha.txt



        // Files.createDirectory(Path.of("/tmp/custos")); // erro se o direotiro ja existir


        // Files.createDirectory(Path.of("/tmp/custos/teste1/teste")); // erro se um endereco intermediario nao existir
        Files.createDirectories(Path.of("/tmp/custos/viagem/brasil"));


       // Files.copy(Paths.get("/Users/eduardosantana/teste.txt"), Paths.get("/tmp/custos/viagem/brasil/teste.txt"));

       // Files.copy(Paths.get("/tmp"), Paths.get("/tmp/teste"));

        Files.copy(Paths.get("/tmp"), Paths.get("/tmp/teste"), StandardCopyOption.REPLACE_EXISTING);



      //  Files.move(Path.of("C:\\temp"), Path.of("C:\\temp-old"));

      //  Files.move(Path.of("C:\\temp\\planilha.txt"), Path.of("C:\\temp-old\\planilha-2.txt"));

      //  Files.move(Path.of("planilha-old.txt"), Path.of("planilha.txt"), StandardCopyOption.ATOMIC_MOVE);




      //  Files.delete(Paths.get("/tmp/planilha.txt"));
        Files.deleteIfExists(Paths.get("/tmp/planilha.txt"));



        Path filePath = Path.of("/Users/eduardosantana/teste.txt");

        String content = Files.readString(filePath);

        System.out.println(content);


        Path filePath2 = Path.of("/Users/eduardosantana/teste.txt");
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(filePath2, StandardCharsets.UTF_8)) {
            //Read the content with Stream
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String fileContent = contentBuilder.toString();
        System.out.println(fileContent);



        try
        {
            byte[] bytes = Files.readAllBytes(filePath);
            System.out.println(bytes);
            fileContent = new String (bytes);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        Files.writeString(Paths.get("/Users/eduardosantana/teste2.txt"), "My string to save", StandardOpenOption.CREATE);


        System.out.println(Files.getLastModifiedTime(Path.of("/Users/eduardosantana/teste2.txt"), LinkOption.NOFOLLOW_LINKS ).toString());
        try (Stream<Path> paths = Files.walk(Paths.get("/Users/eduardosantana/"), 3)) {
            paths
                    .filter(x -> Files.isRegularFile(x))
                    .forEach(System.out::println);
        }
    }

    public static void imprimirInformacoesDoPath(Path path) {
        System.out.println("Arquivo: " + path.getFileName());
        System.out.println(" Raiz: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null)
            System.out.println(" Diretorio pai: " + currentParent);
        System.out.println();
    }


    public static void infoIO(File file) {
        if (file.exists()) {
            System.out.println("Caminho absoluto: " + file.getAbsolutePath());
            System.out.println("Diretorio?: " + file.isDirectory());
            System.out.println("Caminho pai: " + file.getParent());
            if (file.isFile()) {
                System.out.println("Tamanho: " + file.length());
                System.out.println("Ultima modificacao: " + file.lastModified());
            } else {
                for (File subfile : file.listFiles()) {
                    System.out.println(" " + subfile.getName());
                }
            }
        }
    }

    public static void infoNIO(Path path) throws IOException {
        if (Files.exists(path)) {
            System.out.println("Caminho absoluto: " + path.toAbsolutePath());
            System.out.println("Diretorio?: " + Files.isDirectory(path));
            System.out.println("Caminho pai: " + path.getParent());
            if (Files.isRegularFile(path)) {
                System.out.println("Tamanho: " + Files.size(path));
                System.out.println("Ultima modificacao: " + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> stream = Files.list(path)) {
                    stream.forEach(p -> System.out.println(" " + p.toAbsolutePath()));
                }
            }
        }
    }


}
