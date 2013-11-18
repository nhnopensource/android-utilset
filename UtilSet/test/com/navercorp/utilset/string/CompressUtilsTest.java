package com.navercorp.utilset.string;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

/**
 * @author jaemin.woo
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
public class CompressUtilsTest {
	private static String LONG_LONG_STRING = "qwertyuiopassdfghjklxcvbnm!@#$%^&*()";

	@Before
	public void setUp() {
		ShadowLog.stream = System.out;
	}

	@Test
	public void shouldCompressString() {
		String compressed = CompressUtils.compressString(LONG_LONG_STRING);
		assertThat(compressed, is(not(LONG_LONG_STRING)));
	}
	
	@Test
	public void shouoldRestoreCompressedStringToOriginalString() {
		String compressed = CompressUtils.compressString(LONG_LONG_STRING);
		assertThat(compressed, is(not(LONG_LONG_STRING)));
		
		String restored = CompressUtils.decompressString(compressed);
		assertThat(restored, is(not(compressed)));
		assertEquals(LONG_LONG_STRING, restored);
	}
}