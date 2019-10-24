import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TareasAdapter extends RecyclerView.Adapter<TareaViewHolder> {

    List<Map<String,Object>> datos;
    Map<Object, Map<String, Object>> datos;
    Context context;
    private LayoutInflater ensamblador = null;
    private Object[] keys = null;

    public TareasAdapter(Context context, List<Map<String,Object>> datos){
        if(datos==null){
            datos = new ArrayList<>();
        }
        this.datos = datos;
    public TareasAdapter(Context context){
        this.context = context;
        this.ensamblador = LayoutInflater.from(this.context);
        datos = new HashMap<>();
    }

public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        Map<String, Object> dato = (Map<String, Object>) this.datos.get(position);
        holder.titulo.setText(dato.get("titulo").toString());
        holder.descripcion.setText(dato.get("descripcion").toString());
        holder.hecho.setChecked((boolean)dato.get("hecho"));
        Map<String, Object> dato = (Map<String, Object>) this.datos.get(this.keys[position]);
        if(dato!=null) {
            holder.titulo.setText(dato.get("name").toString());
            holder.descripcion.setText(dato.get("description").toString());
            holder.hecho.setChecked(Boolean.parseBoolean(String.valueOf(dato.get("done"))));
        }
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

    public void setDatos(Map<Object, Map<String, Object>> datos) {
        this.datos = datos;
        this.keys = datos.keySet().toArray();
    }
}
