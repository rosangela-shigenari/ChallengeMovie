import com.oracle.javafx.jmx.json.JSONException;
import com.sun.deploy.net.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieTitleTest{
    @Test
    public void getCarModelDetails_valid() throws JSONException {
        HttpResponse responseGet = Mockito.mock(HttpResponse.class);
        when(responseGet.getStatusCode()).thenReturn(200);
    }

}
