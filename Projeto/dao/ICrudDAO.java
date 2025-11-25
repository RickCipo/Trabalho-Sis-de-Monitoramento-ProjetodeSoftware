package dao;

import java.util.List;

public interface ICrudDAO<T> {
    
    // Todo DAO terá que ter um método salvar
    void salvar(T objeto);
    
    // Futuramente, você pode obrigar a ter esses também:
    // void atualizar(T objeto);
    // void deletar(int id);
    // T buscarPorId(int id);
    // List<T> listarTodos();
}