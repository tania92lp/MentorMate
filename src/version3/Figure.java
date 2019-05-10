package version3;

import java.util.Arrays;

public class Figure implements Printable{

    private Integer size;
    private String[] result;

    public Figure(Integer size) throws IllegalArgumentException {
        this.setSize(size);
        this.result = new String[size +1];
    }

    @Override
    public void print() {
        String fixedStars = repeat('*', size);

        for (int a = size, b = size, c = size; a > size/2; a--, b+=2, c-=2) {
            String firstDashes = repeat('-', a);
            String stars = repeat('*', b);
            String innerDashes = repeat('-', c);

            StringBuilder upperRow = new StringBuilder();
            StringBuilder bottomRow = new StringBuilder();

            upperRow.append(firstDashes).append(stars).append(innerDashes).append(stars).append(firstDashes);
            upperRow.append(upperRow);
            int index = size-a;
            result[index] = upperRow.toString();

            firstDashes = repeat('-', index);
            bottomRow.append(firstDashes).append(fixedStars).append(innerDashes).append(stars).append(innerDashes).append(fixedStars).append(firstDashes);
            bottomRow.append(bottomRow);
            result[size -index] = bottomRow.toString();

        }


         Arrays.stream(result).forEach(row -> System.out.println(row));
    }


    private void setSize(Integer size) throws IllegalArgumentException {
        if(size < 2 || size > 10000 || size %2 == 0){
            throw new IllegalArgumentException("Input should be ODD number between 2 and 10 000!");
        }

        this.size = size;
    }

    private String repeat(Character ch, Integer times){
        char[] chars = new char[times];
        Arrays.fill(chars, ch);

        return new String(chars);
    }
}
