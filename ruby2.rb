def zamena_zero(s, k)
  max_one_count = 0  # Максимальное значение единиц
  zero_count = 0     # Количество нулей в текущем окне
  j = 0              # Левая граница окна

  (0...s.length).each do |i|
    if s[i] == '0'
      zero_count += 1  # Увеличиваем счетчик нулей
    end

    while zero_count > k
      if s[j] == '0'
        zero_count -= 1  # Уменьшаем счетчик нулей
      end
      j += 1
    end

    current_length = i - j + 1
    max_one_count = [max_one_count, current_length].max
  end

  max_one_count
end

def check_binary(s)
  s.each_char do |c|
    unless c == '0' || c == '1'
      puts "Строка бинарная и должна состоять только из 0 и 1"
      exit
    end
  end
end

print "Введите бинарную строку: "
s = gets.chomp
check_binary(s)

print "Введите число K: "
k = gets.chomp.to_i

if k < 0
  puts "Данное число не может быть меньше 0"
  exit
end

result = zamena_zero(s, k)
puts "Максимальная длина последовательности единиц: #{result}"
