def pozition(n)
  position = -1
  position_count = 0
  new_n = n
  
  while new_n > 0
    position += 1
    number = new_n % 10
    new_n /= 10
    if position % 2 != 0 && number % 2 != 0
      position_count += 1
    end
  end
  
  if (position_count == (position + 1) / 2) && (position > 0)
    n
  else
    0
  end
end

puts "Сколько чисел вы планируете вводить?"
number_count = gets.chomp.to_i

puts "Вводите числа"
sum = 0

number_count.downto(1) do |i|
  number = gets.chomp.to_i
  sum += pozition(number)
end

puts sum
