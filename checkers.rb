require 'builder'

blacksquare = "fill:#666666;stroke:#000000;stroke-width:0.5;"
whitesquare = "fill:#cccccc;stroke:#000000;stroke-width:0.5;"
blackpiece = "fill:#333333;stroke:#000000;"
whitepiece = "fill:#999999;stroke:#000000;"

b = Builder::XmlMarkup.new(target: STDOUT, indent: 2)
b.svg(xmlns: "http://www.w3.org/2000/svg", width: 84, height: 84) do
  b.g do
    0.upto(7) do |i|
      0.upto(7) do |j|
        if i % 2 == j % 2 then
          b.rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: whitesquare)
        else
          b.rect(width: 10, height: 10, x: 2 + 10 * j, y: 2 + 10 * i, style: blacksquare)
          if i <= 2 then
            b.circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4, style: whitepiece)
          end
          if i >= 5 then
            b.circle(cx: 2 + 5 + 10 * j, cy: 2 + 5 + 10 * i, r: 4, style: blackpiece)
          end
        end
      end
    end
  end
end

