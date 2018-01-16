import com.fasterxml.jackson.databind.ObjectMapper;
import com.turvo.controller.AssetTrackingController;
import com.turvo.model.AssetLocationTracker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(MockitoJUnitRunner.class)
public class AssetTrackingControllerTest {

	private MockMvc mvc;
	@Mock
	AssetTrackingController  assetTrackingController;
	private JacksonTester<AssetLocationTracker> assetLocationTracker;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		// MockMvc standalone approach
		mvc = MockMvcBuilders.standaloneSetup(assetTrackingController).build();
	}

	@Test
	public void testGetLocations() throws Exception {
		MockHttpServletResponse response  = mvc.perform(get("/locations")
												.accept(MediaType.parseMediaType("application/json"))
								 				.accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void testSaveAsset() throws Exception {
		MockHttpServletResponse response  = mvc.perform(post("/asset/save")
											.contentType(MediaType.APPLICATION_JSON)
										    .content(assetLocationTracker.write(new AssetLocationTracker()).getJson())).andReturn().getResponse();

		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
}
