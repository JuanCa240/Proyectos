package TallerXML1;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class EscribirXML {
     public void guardarProductosEnXML(String rutaArchivo, List<Producto> productos) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            Element root = documento.createElement("Productos");
            documento.appendChild(root);

            for (int i = 0; i < productos.size(); i++) {
                Producto producto = productos.get(i);

                Element productoElemento = documento.createElement("Producto");

                Element codigo = documento.createElement("Codigo");
                codigo.appendChild(documento.createTextNode(producto.getCodigo()));

                Element nombre = documento.createElement("Nombre");
                nombre.appendChild(documento.createTextNode(producto.getNombre()));

                Element precio = documento.createElement("Precio");
                precio.appendChild(documento.createTextNode(String.valueOf(producto.getPrecio())));

                Element categoria = documento.createElement("Categoria");
                categoria.appendChild(documento.createTextNode(producto.getCategoria()));

                productoElemento.appendChild(codigo);
                productoElemento.appendChild(nombre);
                productoElemento.appendChild(precio);
                productoElemento.appendChild(categoria);

                root.appendChild(productoElemento);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println("Error al guardar el archivo XML: " + e.getMessage());
        }
    }
}


