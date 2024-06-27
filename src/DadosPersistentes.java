import java.io.IOException;

public interface DadosPersistentes {
    void salvar(String filePath) throws IOException;
}

import java.io.IOException;

public interface DadosPersistentes {
    void salvar(String filePath) throws IOException;
    void carregar(String filePath) throws IOException, ClassNotFoundException;
}