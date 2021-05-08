package com.savaz.rd.java.basic.practice6.part1;

public class Word implements Comparable<Word> {

    private final String content;

    private final int frequency;

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }


    public Word(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((content == null) ? 0 : content.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Word word = (Word) obj;

        return frequency == word.getFrequency() && content.equals(word.content);
    }

    @Override
    public int compareTo(Word o) {
        int result =  o.frequency - this.frequency;
        if (result == 0) {
            result = this.content.compareTo(o.content);
        }
        return result;
    }

}
