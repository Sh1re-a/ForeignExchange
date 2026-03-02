"use client";

import { useState } from "react";

type ConvertResponse = {
  from: string;
  to: string;
  amount: number;
  rate: number;
  result: number;
};

async function callConvertApi(from: string, to: string, amount: number) {
  const qs = new URLSearchParams({
    from,
    to,
    amount: String(amount),
  });
  const res = await fetch(`http://localhost:8080/api/test?${qs.toString()}`, {
    method: "GET",
  });
  return await res.json() as ConvertResponse;

}

export default function Home() {

  const [data, setData] = useState<ConvertResponse>();

  async function handleConvert() {
    const response = await callConvertApi("EUR", "SEK", 10.0);
    setData(response);
    console.log(response);
  }

  return (
    <div className="flex min-h-screen items-center justify-center bg-zinc-50 font-sans dark:bg-black">
      <main className="flex min-h-screen w-full max-w-3xl flex-col items-center justify-between py-32 px-16 bg-white dark:bg-black sm:items-start">
        <button onClick={handleConvert} className="rounded bg-blue-500 px-4 py-2 text-white hover:bg-blue-600">Convert 10 EUR to SEK</button>
        <h1>{JSON.stringify(data)}</h1>
      </main>
    </div>
  );
}
