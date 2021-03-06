require 'builder'

blacksquare = "fill:#666666;stroke:#000000;stroke-width:0.5;"
whitesquare = "fill:#cccccc;stroke:#000000;stroke-width:0.5;"
blackpiece = "fill:#333333;stroke:#000000;"
whitepiece = "fill:#999999;stroke:#000000;"

Builder::XmlMarkup.new(target: STDOUT, indent: 2).instance_eval do
  def square(i, j, style)
    rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: style)
  end
  def piece(i, j, style)
    circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4, style: style)
  end
  svg(xmlns: "http://www.w3.org/2000/svg", width: 84, height: 84) do
    g do
      0.upto(7) do |i|
        0.upto(7) do |j|
          if i % 2 == j % 2 then
            square(i, j, whitesquare)
          else
            square(i, j, blacksquare)
            if i <= 2 then
              piece(i, j, whitepiece)
            end
            if i >= 5 then
              piece(i, j, blackpiece)
            end
          end
        end
      end
    end
  end
end

