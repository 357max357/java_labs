package builder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class UndoBuilder {
  private StringBuilder stringBuilder;

  private Deque<Action> actions = new ArrayDeque<Action>();

  public UndoBuilder() {
    stringBuilder = new StringBuilder();
  }

  public UndoBuilder(int capacity) {
    stringBuilder = new StringBuilder(capacity);
  }

  public UndoBuilder(CharSequence seq) {
    stringBuilder = new StringBuilder(seq);
  }

  public UndoBuilder(String str) {
    stringBuilder = new StringBuilder(str);
  }

  public void undo() {
    if (!actions.isEmpty()) {
      actions.pop().undo();
    }
  }

  public String toString() {
    return stringBuilder.toString();
  }

  public UndoBuilder append(boolean b) {
    stringBuilder.append(b);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(b).length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(char c) {
    stringBuilder.append(c);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(char[] str) {
    stringBuilder.append(str);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - str.length, stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(char[] str, int offset, int len) {
    stringBuilder.append(str, offset, len);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - len, stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(double d) {
    stringBuilder.append(d);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(d).length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(float f) {
    stringBuilder.append(f);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(f).length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(int i) {
    stringBuilder.append(i);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(i).length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(long lng) {
    stringBuilder.append(lng);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(lng).length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(CharSequence s) {
    stringBuilder.append(s);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - s.length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(CharSequence s, int start, int end) {
    stringBuilder.append(s);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - (start - end), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(Object obj) {
    stringBuilder.append(obj);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - obj.toString().length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(String str) {
    stringBuilder.append(str);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder append(StringBuffer str) {
    stringBuilder.append(str);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length()));
    return this;
  }

  public UndoBuilder appendCodePoint(int codePoint) {
    stringBuilder.appendCodePoint(codePoint);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - String.valueOf(codePoint).length(), stringBuilder.length()));
    return this;
  }

  public int capasity() {
    return stringBuilder.capacity();
  }

  public char charAt(int index) {
    return stringBuilder.charAt(index);
  }

  public IntStream chars() {
    return stringBuilder.chars();
  }

  public int codePointAt(int index) {
    return stringBuilder.codePointAt(index);
  }

  public int codePointBefore​(int index) {
    return stringBuilder.codePointBefore(index);
  }

  public int codePointCount​(int beginIndex, int endIndex) {
    return stringBuilder.codePointCount(beginIndex, endIndex);
  }

  public IntStream codePoints() {
    return stringBuilder.codePoints();
  }

  public int compareTo​(StringBuilder another) {
    return stringBuilder.compareTo(another);
  }

  public UndoBuilder delete​(int start, int end) {
    String deleted = stringBuilder.substring(start, end);
    stringBuilder.delete(start, end);
    actions.add(() -> stringBuilder.insert(start, deleted));
    return this;
  }

  public UndoBuilder deleteCharAt​(int index) {
    char deleted = stringBuilder.charAt(index);
    stringBuilder.deleteCharAt(index);
    actions.add(() -> stringBuilder.insert(index, deleted));
    return this;
  }

  public void ensureCapacity​(int minimumCapacity) {
    stringBuilder.ensureCapacity(minimumCapacity);
  }

  public void getChars​(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
    stringBuilder.getChars(srcBegin, srcEnd, dst, dstBegin);
  }

  public int indexOf​(String str) {
    return stringBuilder.indexOf(str);
  }

  public int indexOf​(String str, int fromIndex) {
    return stringBuilder.indexOf(str, fromIndex);
  }

  public UndoBuilder insert​(int offset, boolean b) {
    stringBuilder.insert(offset, b);
    actions.add(() -> stringBuilder.delete(offset, Boolean.toString(b).length()));
    return this;
  }

  public UndoBuilder insert​(int offset, char c) {
    stringBuilder.insert(offset, c);
    actions.add(() -> stringBuilder.delete(offset, 1));
    return this;
  }

  public UndoBuilder insert​(int offset, char[] str) {
    stringBuilder.insert(offset, str);
    actions.add(() -> stringBuilder.delete(offset, str.length));
    return this;
  }

  public UndoBuilder insert​(int index, char[] str, int offset, int len) {
    stringBuilder.insert(index, str, offset, len);
    actions.add(() -> stringBuilder.delete(index, len));
    return this;
  }

  public UndoBuilder insert​(int offset, double d) {
    stringBuilder.insert(offset, d);
    actions.add(() -> stringBuilder.delete(offset, Double.toString(d).length()));
    return this;
  }

  public UndoBuilder insert​(int offset, float f) {
    stringBuilder.insert(offset, f);
    actions.add(() -> stringBuilder.delete(offset, Float.toString(f).length()));
    return this;
  }

  public UndoBuilder insert​(int offset, int i) {
    stringBuilder.insert(offset, i);
    actions.add(() -> stringBuilder.delete(offset, Integer.toString(i).length()));
    return this;
  }

  public UndoBuilder insert​(int offset, long l) {
    stringBuilder.insert(offset, l);
    actions.add(() -> stringBuilder.delete(offset, Long.toString(l).length()));
    return this;
  }

  public UndoBuilder insert​(int dstOffset, CharSequence s) {
    stringBuilder.insert(dstOffset, s);
    actions.add(() -> stringBuilder.delete(dstOffset, s.length()));
    return this;
  }

  public UndoBuilder insert​(int dstOffset, CharSequence s, int start, int end) {
    stringBuilder.append(s);
    actions.push(() -> stringBuilder.delete(stringBuilder.length() - (start - end), stringBuilder.length()));
    return this;
  }

  public UndoBuilder insert​(int offset, Object obj) {
    stringBuilder.insert(offset, obj);
    actions.add(() -> stringBuilder.delete(offset, obj.toString().length()));
    return this;
  }

  public UndoBuilder insert​(int offset, String str) {
    stringBuilder.insert(offset, str);
    actions.add(() -> stringBuilder.delete(offset, str.length()));
    return this;
  }

  public int lastIndexOf​(String str) {
    return stringBuilder.lastIndexOf(str);
  }

  public int lastIndexOf​(String str, int fromIndex) {
    return stringBuilder.lastIndexOf(str, fromIndex);
  }

  public int length() {
    return stringBuilder.length();
  }

  public int offsetByCodePoints​(int index, int codePointOffset) {
    return stringBuilder.offsetByCodePoints(index, codePointOffset);
  }

  public UndoBuilder replace​(int start, int end, String str) {
    String deleted = stringBuilder.substring(start, end);
    stringBuilder.replace(start, end, str);
    actions.add(() -> stringBuilder.replace(start, end, deleted));
    return this;
  }

  public UndoBuilder reverse() {
    stringBuilder.reverse();
    actions.add(() -> stringBuilder.reverse());
    return this;
  }

  public void setCharAt​(int index, char ch) {
    char deleted = stringBuilder.toString().charAt(index);
    stringBuilder.setCharAt(index, ch);
    actions.add(() -> stringBuilder.setCharAt(index, deleted));
  }

  public void setLength​(int newLength) {
    stringBuilder.setLength(newLength);
  }

  public CharSequence subSequence​(int start, int end) {
    return stringBuilder.subSequence(start, end);
  }

  public String substring​(int start) {
    return stringBuilder.substring(start);
  }

  public String substring​(int start, int end) {
    return stringBuilder.substring(start, end);
  }

  public void trimToSize() {
    stringBuilder.trimToSize();
  }
}