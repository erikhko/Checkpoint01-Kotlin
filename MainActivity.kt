package carreiras.com.github.orgs.ui.activity
/*
    Grupo:
    Erik Hoon Ko                                RM93599
    Murilo de Jesus Gomes Rocha                 RM94965
    Alexandre Ilha de Vilhena                   RM88689
    Rafael Gomes de Almeida Vaz Privitera       RM93617
    Leonardo Rodrigues de Andrade               RM88727
    Thiago Michelle de Oliveira Ieffa           RM87796
*/
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {


    /*
     OnCreate - Primeiro estágio de vida da Activity e se encontra na classe pai,
     herdando suas caracteristicas
    */
    /*
    Bundle possui tudo o que é necessário para manter o estado de vida da activity
    contém os dados salvos da activity. Se a activity está sendo iniciada pela primeira vez,
    o Bundle será nulo. Se a activityestá sendo recriada,
    o Bundle conterá os dados que foram salvos no método onSaveInstanceState antes da activity ser destruída
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

//Criação de função
    override fun onResume() {
        super.onResume()

    /*
    onResume é chamado quando a atividade volta ao primeiro plano (depois de estar em pausa ou parada) ou quando é criada pela primeira vez
    */

    /*    RecyclerView é um componente de interface do usuário android que é
usado para exibir grandes conjuntos de dados de maneira eficiente
 */
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()

        Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")


        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscaTodos()
        )

// Uso de id para encontrar o elemento visual floatingActionButton e passando a
// partir do evento de clique esta trazendo a pagina FormularioProdutoActivity
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}