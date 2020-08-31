package com.dwilliam.utils.strings;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class RandomString {

    /**
     * The {@code String} that contains upper case letters.
     */
    public static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * The {@code String} that contains lower case letters.
     */
    public static final String LOWER_CASE_LETTERS = UPPER_CASE_LETTERS.toLowerCase();

    /**
     * The {@code String} that contains digits.
     */
    public static final String DIGITS = "0123456789";

    /**
     * The {@code String} that contains special characters.
     */
    public static final String SPECIAL_CHARACTERS = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~\"";

    private static final int[] ONE_TIME = {1};

    private final SecureRandom random;
    private final int[] alphabet;
    private final int[] buffer;

    /**
     * Constructs a secure random String generator.
     *
     * @param length  The length of generated strings
     * @param random  The {@code SecureRandom} used to generate strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws IllegalArgumentException if the length of {@code symbols} is lower to 1
     * @throws NullPointerException     if {@code random} is {@code null}
     */
    public RandomString(int length, SecureRandom random, String alphabet) {
        if (length < 0) throw new IllegalArgumentException();
        if (alphabet.length() < 1) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.buffer = new int[length];
        this.alphabet = alphabet.codePoints().toArray();
    }

    /**
     * Constructs a secure random String generator that generate {@code String} that contain
     * upper case letters, lower case letters and digits.
     *
     * @param length The length of generated strings
     * @param random The {@code SecureRandom} used for generate strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws NullPointerException     if {@code random} is {@code null}
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     */
    public RandomString(int length, SecureRandom random) {
        this(length, random, UPPER_CASE_LETTERS + LOWER_CASE_LETTERS + DIGITS);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation.
     *
     * @param length  The length of generated strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower to 1
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(int length, String alphabet) {
        this(length, new SecureRandom(), alphabet);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation
     * and that generate {@code String} that contain upper case letters, lower case letters and
     * digits.
     *
     * @param length The length of generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Constructs a secure random String generator that generate {@code String} of length 8.
     *
     * @param random  The {@code SecureRandom} used for generate strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower or equals to 1
     * @throws NullPointerException     if {@code random} is {@code null}
     */
    public RandomString(SecureRandom random, String alphabet) {
        this(8, random, alphabet);
    }

    /**
     * Constructs a secure random String generator that generate {@code String} of length 8 and
     * that contain upper case letters, lower case letters and digits.
     *
     * @param random The SecureRandom used for generate strings
     * @throws NullPointerException if {@code random} is {@code null}
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     */
    public RandomString(SecureRandom random) {
        this(8, random);
    }

    /**
     * Constructs a secure random String generator with default {@code SecureRandom} implementation
     * and that generate String of length 8.
     *
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if the length of {@code symbols} is lower to 1
     * @see SecureRandom#SecureRandom()
     */
    public RandomString(String alphabet) {
        this(8, alphabet);
    }

    /**
     * Constructs a secure random String generator :
     * <ul>
     * <li>with default {@code SecureRandom} implementation.</li>
     * <li>that generate {@code String} of length 8.</li>
     * <li>that generate {@code String} that contain upper case letters, lower case letters and digits.</li>
     * </ul>
     *
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     */
    public RandomString() {
        this(8);
    }

    /**
     * Generates a new {@code String}, conform to String generator's rules.
     *
     * @return the newly randomly generated {@code String}
     */
    public String nextString() {
        for (int i = 0; i < this.buffer.length; i++) {
            this.buffer[i] = this.alphabet[this.random.nextInt(this.alphabet.length)];
        }
        return new String(this.buffer, 0, this.buffer.length);
    }

    /**
     * Generates a new {@code String}.
     *
     * @param length  The length of generated strings
     * @param random  The {@code SecureRandom} used for generate strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower to 1
     * @throws NullPointerException     if {@code random} is {@code null}
     */
    public static String newString(int length, SecureRandom random, String alphabet) {
        return new RandomString(length, random, alphabet).nextString();
    }

    /**
     * Generates a new {@code String} that contain upper case letters, lower case letters and digits.
     *
     * @param length The length of generated strings
     * @param random The {@code SecureRandom} used for generate strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws NullPointerException     if {@code random} is {@code null}
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @return the newly randomly generated {@code String}
     */
    public static String newString(int length, SecureRandom random) {
        return new RandomString(length, random, UPPER_CASE_LETTERS + LOWER_CASE_LETTERS + DIGITS).nextString();
    }

    /**
     * Generates a new {@code String} with default {@code SecureRandom} implementation.
     *
     * @param length  The length of generated strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower to 1
     * @see SecureRandom#SecureRandom()
     * @return the newly randomly generated {@code String}
     */
    public static String newString(int length, String alphabet) {
        return new RandomString(length, new SecureRandom(), alphabet).nextString();
    }

    /**
     * Generates a new {@code String} with default {@code SecureRandom} implementation
     * and that generate {@code String} that contain upper case letters, lower case letters and
     * digits.
     *
     * @param length The length of generated strings
     * @throws IllegalArgumentException if {@code length} is lower to 0
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     * @return the newly randomly generated {@code String}
     */
    public static String newString(int length) {
        return new RandomString(length, new SecureRandom()).nextString();
    }

    /**
     * Generates a new {@code String} of length 8.
     *
     * @param random  The {@code SecureRandom} used for generate strings
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower to 1
     * @throws NullPointerException     if {@code random} is {@code null}
     * @return the newly randomly generated {@code String}
     */
    public static String newString(SecureRandom random, String alphabet) {
        return new RandomString(8, random, alphabet).nextString();
    }

    /**
     * Generates a new {@code String} of length 8 and
     * that contain upper case letters, lower case letters and digits.
     *
     * @param random The SecureRandom used for generate strings
     * @throws NullPointerException if {@code random} is {@code null}
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @return the newly randomly generated {@code String}
     */
    public static String newString(SecureRandom random) {
        return new RandomString(8, random).nextString();
    }

    /**
     * Generates a new {@code String} with default {@code SecureRandom} implementation
     * and that generate String of length 8.
     *
     * @param alphabet The characters that can appear in generated strings
     * @throws IllegalArgumentException if the length of {@code alphabet} is lower to 1
     * @see SecureRandom#SecureRandom()
     * @return the newly randomly generated {@code String}
     */
    public static String newString(String alphabet) {
        return new RandomString(8, alphabet).nextString();
    }

    /**
     * Generates a new {@code String} :
     * <ul>
     * <li>with default {@code SecureRandom} implementation.</li>
     * <li>that generate {@code String} of length 8.</li>
     * <li>that generate {@code String} that contain upper case letters, lower case letters and digits.</li>
     * </ul>
     *
     * @see #UPPER_CASE_LETTERS
     * @see #LOWER_CASE_LETTERS
     * @see #DIGITS
     * @see SecureRandom#SecureRandom()
     * @return the newly randomly generated {@code String}
     */
    public static String newString() {
        return new RandomString(8).nextString();
    }

}
