package zx.learn.fastjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/23 14:07
 * @Description:
 */
public class testTransferJson {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(s);

    }

}
