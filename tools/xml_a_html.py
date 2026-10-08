"""Convierte un reporte XML de Checkstyle a una tabla HTML."""
import sys
import xml.etree.ElementTree as ET
from html import escape

ESTILO = (
    "body{font-family:sans-serif}"
    "table{border-collapse:collapse}"
    "td,th{border:1px solid #999;padding:4px 8px}"
    "th{background:#ddd}"
)


def convertir(ruta_xml, ruta_html):
    raiz = ET.parse(ruta_xml).getroot()
    filas = []
    for archivo in raiz.findall("file"):
        nombre = archivo.get("name", "").replace("\\", "/").split("/")[-1]
        for error in archivo.findall("error"):
            regla = error.get("source", "").split(".")[-1]
            celdas = [
                escape(nombre),
                error.get("line", ""),
                error.get("column", ""),
                escape(error.get("message", "")),
                escape(regla),
            ]
            filas.append("<tr>" + "".join("<td>" + c + "</td>" for c in celdas) + "</tr>")

    html = (
        "<html><head><meta charset='utf-8'><title>Reporte Checkstyle</title>"
        "<style>" + ESTILO + "</style></head><body>"
        "<h1>Reporte Checkstyle</h1>"
        "<p>Total de hallazgos: " + str(len(filas)) + "</p>"
        "<table><tr><th>Archivo</th><th>Línea</th><th>Columna</th>"
        "<th>Mensaje</th><th>Regla</th></tr>" + "".join(filas) + "</table>"
        "</body></html>"
    )
    with open(ruta_html, "w", encoding="utf-8") as salida:
        salida.write(html)


if __name__ == "__main__":
    convertir(sys.argv[1], sys.argv[2])