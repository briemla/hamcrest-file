package de.briemla.hamcrest.matcher.file;

import java.io.File;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class HasEqualContent extends TypeSafeMatcher<File> {

	private final File expected;

	public HasEqualContent(File expected) {
		super();
		this.expected = expected;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("is equal to ");
		description.appendText(expected.getAbsolutePath());
	}

	@Override
	protected boolean matchesSafely(File file) {
		List<String> expectedContent = Content.of(expected);
		List<String> fileContent = Content.of(file);
		return expectedContent.equals(fileContent);
	}

	@Override
	protected void describeMismatchSafely(File item, Description mismatchDescription) {
		mismatchDescription.appendText("differs from ");
		mismatchDescription.appendText(expected.getAbsolutePath());
	}

}
