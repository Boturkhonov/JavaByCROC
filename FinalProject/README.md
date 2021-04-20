## Final homework
- Sample input files (xml): [files/](files)
- Sample output files (json): [output/](output)
- Xml validation files (xsd): [xsd/](xsd)
- Model classes of input files: [src/model/input/](src/model/input)
- Util class for reading xml files: [MyXmlReader.java](src/model/input/MyXmlReader.java)
- Model classes of output files: [src/model/output/](src/model/output)
- Util class for writing json files: [MyJsonWriter.java](src/model/output/MyJsonWriter.java)
- Class for solving first and second tasks: [Solver.java](src/controller/Solver.java)

- And other classes: [Controller.java](src/controller/Controller.java), [MainFrame.java](src/view/MainFrame.java), 
  [MyStorage.java](src/model/MyStorage.java), [Main.java](src/Main.java)
  
### Вариант №1
| Задание | Описание|
|-------|-------------|
|<center> 1 </center>| Для каждого товара вывести в файл продавца, у которого наименьшая цена на этот товар, и саму цену на этот товар у этого продавца |
|<center> 2 </center>| Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров |

#### Формат файлов
| Входной файл | Выходной файл |
|--------------|---------------|
|<center> XML </center> |<center> JSON </center>|