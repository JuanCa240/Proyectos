package MiniProyecto3;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class OperacionesXML {
    private static final String ARCHIVO_XML = "C:\\Users\\Juan Camilo\\OneDrive\\Documentos\\NetBeansProjects\\Semestre 3\\MiniProyecto\\productos.xml";

    public static void crearArchivoXML() {
        try {
            File archivo = new File(ARCHIVO_XML);
            if (!archivo.exists()) {
                DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
                Document document = documentBuilder.newDocument();

                Element raiz = document.createElement("productos");
                document.appendChild(raiz);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(archivo);
                transformer.transform(source, result);
            }
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error al configurar o transformar el documento XML: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public static void agregarProducto(Producto producto) {
        try {
            File archivo = new File(ARCHIVO_XML);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            // Crear el nuevo producto
            Element nuevoProducto = document.createElement("producto");

            Element nombre = document.createElement("nombre");
            nombre.appendChild(document.createTextNode(producto.getNombre().trim()));
            nuevoProducto.appendChild(nombre);

            Element codigo = document.createElement("codigo");
            codigo.appendChild(document.createTextNode(producto.getCodigo().trim()));
            nuevoProducto.appendChild(codigo);

            Element precio = document.createElement("precio");
            precio.appendChild(document.createTextNode(String.valueOf(producto.getPrecio())));
            nuevoProducto.appendChild(precio);

            Element categoria = document.createElement("categoria");
            categoria.appendChild(document.createTextNode(producto.getCategoria().toString().trim()));
            nuevoProducto.appendChild(categoria);

            Element imagen = document.createElement("imagen");
            imagen.appendChild(document.createTextNode(producto.getImagen().toString().trim()));
            nuevoProducto.appendChild(imagen);

            Node productos = document.getElementsByTagName("productos").item(0);
            productos.appendChild(nuevoProducto);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(archivo);
            transformer.transform(source, result);

        } catch (FileNotFoundException e) {
            System.out.println("El archivo XML no se encontró: " + e.getMessage());
        } catch (IOException e) {
             System.out.println("Error al leer o escribir en el archivo XML: " + e.getMessage());
        } catch (Exception e) {
             System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public static void eliminarProducto(String codigo) {
        try {
            File archivo = new File(ARCHIVO_XML);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            NodeList listaProductos = document.getElementsByTagName("producto");
            for (int i = 0; i < listaProductos.getLength(); i++) {
                Node nodo = listaProductos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element productoElement = (Element) nodo;
                    String codigoProducto = productoElement.getElementsByTagName("codigo").item(0).getTextContent();
                    if (codigoProducto.equals(codigo)) {
                        productoElement.getParentNode().removeChild(productoElement);
                        break;
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(archivo);
            transformer.transform(source, result);

        } catch (FileNotFoundException e) {
            System.out.println("El archivo XML no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer o escribir en el archivo XML: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
    
    public static void editarProducto(String codigo, Producto productoEditado) {
        try {
            File archivo = new File(ARCHIVO_XML);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            NodeList listaProductos = document.getElementsByTagName("producto");
            for (int i = 0; i < listaProductos.getLength(); i++) {
                Node nodo = listaProductos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element productoElement = (Element) nodo;
                    String codigoProducto = productoElement.getElementsByTagName("codigo").item(0).getTextContent();
                    if (codigoProducto.equals(codigo)) {
                        productoElement.getElementsByTagName("nombre").item(0).setTextContent(productoEditado.getNombre());
                        productoElement.getElementsByTagName("precio").item(0).setTextContent(String.valueOf(productoEditado.getPrecio()));
                        productoElement.getElementsByTagName("categoria").item(0).setTextContent(productoEditado.getCategoria().toString());
                        productoElement.getElementsByTagName("imagen").item(0).setTextContent(productoEditado.getImagen().toString());
                        break;
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(archivo);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.getMessage();
        }
    }



    public static List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        try {
            File archivo = new File(ARCHIVO_XML);
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);

            NodeList listaProductos = document.getElementsByTagName("producto");

            for (int i = 0; i < listaProductos.getLength(); i++) {
                Node nodo = listaProductos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element productoElement = (Element) nodo;

                    String nombre = productoElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String codigo = productoElement.getElementsByTagName("codigo").item(0).getTextContent();
                    double precio = Double.parseDouble(productoElement.getElementsByTagName("precio").item(0).getTextContent());
                    Producto.Categoria categoria = Producto.Categoria.valueOf(productoElement.getElementsByTagName("categoria").item(0).getTextContent());
                    String imagenPath = productoElement.getElementsByTagName("imagen").item(0).getTextContent();

                    Image imagen = Toolkit.getDefaultToolkit().getImage(imagenPath);

                    Producto producto = new Producto(nombre, codigo, precio, categoria, imagen);
                    productos.add(producto);
                }
            }
        } catch (FileNotFoundException e) {
             System.out.println("El archivo XML no se encontró: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        } catch (Exception e) {
             System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
        return productos;
    }
}

