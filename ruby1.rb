def flowers(water_count, volume)
  x = volume # объем лейки
  steps = 0  # кол-во шагов

  water_count.each_with_index do |water, i|
    if x - water >= 0 # если воды достаточно
      x -= water
      steps += 1
    else # если воды недостаточно
      x = volume # набираем лейку у реки
      steps += 2 * (i + 1) - 1 # шаги до реки и обратно
      x -= water
    end
  end

  steps
end

def bags(flower_count) # проверка входящих значений
  if flower_count < 0
    puts "введено невозможное значение"
    exit(0) # завершаем программу при ошибке
  end
end

# Основная программа
puts "Введите количество цветов: "
flowers_count = gets.chomp.to_i
bags(flowers_count)

water_counts = []
puts "Введите кол-во воды, нужное для каждого цветка:"

(0...flowers_count).each do |i|
  print "#{i + 1} цветок: "
  water = gets.chomp.to_i
  bags(water)
  water_counts << water
end

puts "Введите объем лейки: "
volume = gets.chomp.to_i
bags(volume)

steps = flowers(water_counts, volume)
puts "#{steps} шагов вы сделаете"
