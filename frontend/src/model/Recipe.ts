export type Recipe = {
    id: string,
    name: string,
    image: string,
    ingredients: string[],
    preparation: string,
    portions: string,
    categories: "ASIAN" | "EUROPEAN" | "MEDITERRANEAN"
}