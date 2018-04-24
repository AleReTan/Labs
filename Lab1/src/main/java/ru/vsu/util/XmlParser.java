package ru.vsu.util;

import ru.vsu.entity.entityImpl.Car;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {

    static private String MODEL = "model";
    static private String PRICE = "price";
    static private String COLOR = "color";
    static private String CAR_DATE_MANUFACTURE = "carDateManufacture";
    static private String ID = "id";
    static private String CAR = "car";

    public List<Car> parse(String inputFile) throws ParseException {
        List<Car> cars = new ArrayList<Car>();

        try {
            // Создаем XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(inputFile);
            // читаем XML'ку
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            Car car = null;
            //пока есть еще события
            while (eventReader.hasNext()) {
                //берем событие за текущее
                XMLEvent event = eventReader.nextEvent();
                //проверяем является ли текущее событие первым, если является утанавливаем стартовый элемент
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if (startElement.getName().getLocalPart().equals(CAR)) {
                        car = new Car();
                    }

                    if (event.isStartElement()) {
                        if (event.asStartElement().getName().getLocalPart().equals(MODEL)) {
                            event = eventReader.nextEvent();
                            car.setModel(event.asCharacters().getData());
                            continue;
                        }
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(PRICE)) {
                        event = eventReader.nextEvent();
                        car.setPrice(Integer.parseInt(event.asCharacters().getData()));
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(COLOR)) {
                        event = eventReader.nextEvent();
                        car.setColor(event.asCharacters().getData());
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(CAR_DATE_MANUFACTURE)) {
                        event = eventReader.nextEvent();
                        car.setCarDateManufacture(Integer.parseInt(event.asCharacters().getData()));
                        continue;
                    }

                    if (event.asStartElement().getName().getLocalPart().equals(ID)) {
                        event = eventReader.nextEvent();
                        car.setId(Integer.parseInt(event.asCharacters().getData()));
                        continue;
                    }
                }
                //как нашли последний элемент, добавляем
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(CAR)) {
                        cars.add(car);

                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return cars;
    }
}