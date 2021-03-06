package de.briemla.hamcrest.matcher.file;

import java.io.File;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class IsEmpty extends TypeSafeMatcher<File> {

	@Override
	public void describeTo(Description description) {
		description.appendText("file is empty");
	}

	@Override
	protected boolean matchesSafely(File item) {
		List<String> content = Content.of(item);
		return content.isEmpty();
	}

	@Override
	protected void describeMismatchSafely(File item, Description mismatchDescription) {
		mismatchDescription.appendText("file contains: " + Content.of(item));
	}
}