package servlets.rest;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExampleRestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json"); //указываем формат ответа (что это json)
        resp.setCharacterEncoding("UTF-8");//укажем кодировку
        //создаем List и указываем, что там будут храниться мапы
        List <Map<String,Object>> list = new ArrayList<>();


        //теперь создадим три объекта (тестовых) в дальнейшем будем данные из бд получать

        Map<String,Object> obj1 = new HashMap();
        obj1.put("id","first");
        obj1.put("name","раз");
        obj1.put("description","первый объект");

        Map<String,Object> obj2 = new HashMap();
        obj2.put("id","second");
        obj2.put("name","два");
        obj2.put("description","второй объект");

        Map<String,Object> obj3 = new HashMap();
        obj3.put("id","last");
        obj3.put("name","три");
        obj3.put("description"," объект");

        //////

        //добавим 3 объекта в список
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);


        ///теперь нужно объект превратить в строку (json)
        ///можно сделать вручную, но предлагаю подключить библиотеку GSON и ей сделать преобразование

        String json = new Gson().toJson(list);

        //теперь объект имеет строковый вид и его можно вернуть
        resp.getWriter().println(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //я ожидаю что на вход поступит json такого формата и с определенными полями { "id": "test", "name": "название" }
        req.setCharacterEncoding("UTF-8");//кодировка

        //получаю входящий json
        StringBuilder requestBodyBuilder = new StringBuilder();
        BufferedReader reader = req.getReader();

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBodyBuilder.append(line);
            }
        } finally {
            reader.close();
        }

        String json = requestBodyBuilder.toString();


        ///получение можно вынести в отдельный класс или воспользоваться способом в 1 строчку (только разберитесь)
        //String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        ///теперь преобразуем строковый json в объект Map
        Map<String,Object> obj = new Gson().fromJson(json, Map.class);

        //ну и просто выведем в консоль (обратившись по ключу). Далее эти данные можно записать в БД
        System.out.println(obj.get("login"));
        System.out.println(obj.get("password"));
        System.out.println(obj.get("new-data"));

        ///теперь сообщим, что данные получены.


        /// создаем объект
        Map<String,Object> answerMap = new HashMap();

        /// заполним
        answerMap.put("status","success");
        answerMap.put("msg","данные получены");


        //преобразуем в строку
        String respJson = new Gson().toJson(answerMap);
        resp.setContentType("application/json"); //указываем формат ответа (что это json)
        resp.setCharacterEncoding("UTF-8");//укажем кодировку
        //вернем клиенту
        resp.getWriter().println(respJson);

    }
}
