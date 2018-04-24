package ru.vsu.util;
import ru.vsu.entity.entityImpl.Car;

import javax.xml.stream.XMLEventFactory;
        import javax.xml.stream.XMLEventWriter;
        import javax.xml.stream.XMLOutputFactory;
        import javax.xml.stream.XMLStreamException;
        import javax.xml.stream.events.*;
        import java.io.FileOutputStream;
        import java.util.List;

public class XmlWriter {
    public void saveCars(String filePath ,List<Car> cars) throws Exception {
        //создаем XMLOutputFactory
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        //создаем XMLEventWriter
        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(filePath));
        //создаем an EventFactory
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        //перевод строки и табуляция
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");

        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);
        //переводим строчку
        eventWriter.add(end);
        // создаем открывающий тег
        StartElement studentStartElement = eventFactory.createStartElement("", "", "cars");
        eventWriter.add(studentStartElement);
        eventWriter.add(end);

        for (Car car : cars) {
            eventWriter.add(tab);
            StartElement studentStartElement1 = eventFactory.createStartElement("", "", "car");
            eventWriter.add(studentStartElement1);
            eventWriter.add(end);
            eventWriter.add(tab);
            createNode(eventWriter, "model", car.getModel());
            eventWriter.add(tab);
            createNode(eventWriter, "price", String.valueOf(car.getPrice()));
            eventWriter.add(tab);
            createNode(eventWriter, "color", car.getColor());
            eventWriter.add(tab);
            createNode(eventWriter, "carDateManufacture", String.valueOf(car.getCarYearManufacture()));
            eventWriter.add(tab);
            createNode(eventWriter, "id", String.valueOf(car.getId()));
            eventWriter.add(tab);
            eventWriter.add(eventFactory.createEndElement("", "", "car"));
            eventWriter.add(end);
        }

        eventWriter.add(eventFactory.createEndElement("", "", "students"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }

    private void createNode(XMLEventWriter eventWriter, String name,
                            String value) throws XMLStreamException {

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        // создаем начальный тэг
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // заполнем
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        // создаем закрывающий тэг
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
}

