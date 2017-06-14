package de.briemla.hamcrest.matcher.file;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class Contains extends TypeSafeMatcher<File> {

	private final List<String> lines;

	public Contains(String... lines) {
		super();
		this.lines = Arrays.asList(lines);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("contains: " + Arrays.asList(lines));
	}

	@Override
	protected boolean matchesSafely(File item) {
		List<String> content = Content.of(item);
		return lines.size() == content.size() && lines.equals(content);
	}

	@Override
	protected void describeMismatchSafely(File item, Description mismatchDescription) {
		mismatchDescription.appendText("contains: " + Content.of(item));
	}
}