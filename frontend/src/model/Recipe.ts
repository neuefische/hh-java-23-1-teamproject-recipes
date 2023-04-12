export type Recipe = {
    id: string,
    name: string,
    category: "ASIAN" | "EUROPEAN" | "MEDITERRANEAN"
}

export type NewRecipe = {
    name: string,
    category: "ASIAN" | "EUROPEAN" | "MEDITERRANEAN"
}